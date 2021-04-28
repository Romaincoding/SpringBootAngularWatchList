from bdd.db_manager import DbManager
import sys
from pathlib import Path


def install(dbUserFile, dbQueryFile):
    # instanciate dB object
    db = DbManager(dbUserFile)

    # install DB using local user config
    if dbQueryFile != None:
        db.installDb(dbQueryFile)

    # open hibernate template
    fp = open("config/application.properties.template", "r")
    content = fp.read()
    fp.close()

    # update hibernate content
    content = content.replace("[CFG_DB_ADDR]"   , db.getHost()    )
    content = content.replace("[CFG_DB_NAME]"   , db.getDbName()  )
    content = content.replace("[CFG_DB_LOGIN]"  , db.getLogin()   )
    content = content.replace("[CFG_DB_PWD]"    , db.getPwd()     )
    content = content.replace("[CFG_DB_PORT]"   , db.getPort()    )
    content = content.replace("[CFG_BACK_PORT]" , db.getBackPort())

    # (re)Create the hibernate config XML file
    fp = open("../../src/main/resources/application.properties", "w")
    fp.write(content)
    fp.close()

    print("END. Please press a key.")
    input()


if __name__ == "__main__":

    # init params
    params = { "-cfg": {"help":"input file containing DB user information as login, password, db name and host address",
                        "value":None},
               "-f": {"help":"DB install config. file",
                      "value":None  },
             }

    # Retrieve all parameters
    paramOK = True
    try:
        i = 0
        while i < len(sys.argv):
            p = sys.argv[i]
            if p in params:
                params[p]["value"] = sys.argv[i+1]
            i += 1
    except:
        paramOK = False
    # check if one of the compulsory fields are not filled
    if params["-cfg"]["value"] == None:
        paramOK = False

    # display error message
    if not paramOK:
        print("\n[install command] -> parameter format ")
        for p in params:
            print(f"  {p} : {params[p]['help']}")
        exit()


    # get config dir
    currentDir = Path(__file__).parent.resolve()
    configDir = currentDir / "config"

    # Prepare input
    dbPath = None
    filePath = None
    if params["-cfg"]["value"] != None:
        dbPath   = str(configDir / Path(params["-cfg"]["value"]))
    if params["-f"]["value"] != None:
        filePath = str(configDir / Path(params["-f"]["value"]))

    # Install DB
    install(dbPath, filePath)

