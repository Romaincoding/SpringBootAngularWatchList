
import mysql.connector  as db
import re


class DbManager():

    # =========================================================================
    # PRIVATE METHODS
    # =========================================================================

    # Try to connect to an host and DB
    def _connect(self):
        # If a connection is already established, close it
        if self._cnx != None:
            self._disconnect()

        # Connection to the DB
        try:
            self._cnx = db.connect(user=self._login, password=self._pwd, host=self._host, database=self._dbName, auth_plugin='mysql_native_password')
            self._cursor = self._cnx.cursor(buffered=True)
            res = True
        except:
            # Connection to the host only
            try:
                self._cnx = db.connect(user=self._login, password=self._pwd, host=self._host, auth_plugin='mysql_native_password')
                self._cursor = self._cnx.cursor(buffered=True)
                res = False
            except:
                # Nothing worked !
                res = None

        # if the host is not reachable, return None
        # if the host is reachable and the database does not exist, return False
        # return True if the db connection succeeds
        return res

    # Disconnect from the host
    def _disconnect(self):
        self._cnx.close()
        self._cursor = None
        self._cnx    = None

    # Execute a simple query
    def _executeQuery(self, query):
        print("--------------------------------------")
        print("EXECUTING QUERY")
        print("--------------------------------------")
        print(query + '\n')
        self._cursor.execute(query)

    #Send all the SQL queries contained in a configuration file
    def _processCfgFile(self, cfgFilePath):
        # open WatchList BDD Struct file and retrieve content
        fp = open(cfgFilePath, "r")
        content = fp.read()
        fp.close()
        # Prepare regex
        regex = r"([ALTER|SELECT|UPDATE|INSERT|CREATE][\s\S]+?\;)\s*"
        pattern = re.compile(regex)
        result = pattern.findall(content)
        # Process each found query
        for query in result:
            self._executeQuery(query)

        # Commit the whole work
        self._cnx.commit()
        # close connection
        self._disconnect()


    # =========================================================================
    # CONSTRUCTOR
    # =========================================================================

    def __init__(self, dbUserFile):
        self._login    = None
        self._pwd      = ""
        self._dbName   = None
        self._host     = "127.0.0.1"
        self._dbPort   = "3306"
        self._backPort = "8090"

        fp = open(dbUserFile,"r")
        lines = fp.readlines()
        fp.close()
        for line in lines:
            row = line.split(":")
            if len(row) >= 2:
                field = row[0].strip()
                value = row[1].strip()
                print(field, value)
                if field == "login":
                    self._login  = value
                if field == "pwd":
                    self._pwd    = value
                if field == "host":
                    self._host   = value
                if field == "dbName":
                    self._dbName = value
                if field == "port":
                    self._dbPort = value
                if field == "back_port":
                    self._backPort = value

        self._cnx    = None
        self._cursor = None


    # =========================================================================
    # PUBLIC METHODS
    # =========================================================================
    def installDb(self, dbStructFilePath):
        # Connect to server and get cursor from connection object
        res = self._connect()

        # if the database does not exist, create it
        if res == False:
            query = f"CREATE DATABASE `{self._dbName}`"
            self._executeQuery(query)
            self._cnx.commit()

        # Retry to connect now the database exists
        res = self._connect()

        # The database exists, process the configuration file
        # to fill it from scratch
        if res == True:
            self._processCfgFile(dbStructFilePath)

    def getLogin(self):
        return self._login
    def getPwd(self):
        return self._pwd
    def getDbName(self):
        return self._dbName
    def getHost(self):
        return self._host
    def getPort(self):
        return self._dbPort
    def getBackPort(self):
        return self._backPort
