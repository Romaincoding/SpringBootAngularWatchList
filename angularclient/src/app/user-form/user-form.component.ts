import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/user/user.service';
import { User } from '../model/user';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomValidators } from '../custom-validators';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  user: User;
  userForm: FormGroup;

  constructor(
  private userService: UserService,
  private formBuilder: FormBuilder,
    private route: ActivatedRoute,
      private router: Router,
  ){}

   ngOnInit(): void {
       this.initUserForm();
     }


  initUserForm() {
      this.userForm = this.formBuilder.group({
        pseudo: ['', Validators.required],
        password: [
          '',
          Validators.compose([Validators.minLength(6), Validators.required]),
        ],
        email: ['', Validators.compose([Validators.email, Validators.required])],
        confirmPassword: ['', Validators.required],
      },
      {
        validator: CustomValidators.passwordMatchValidator
      });
    }

  onSubmit() {
    this.user = {
    pseudo : this.userForm.value.pseudo,
    email: this.userForm.value.email,
    password: this.userForm.value.password,
    }
    this.userService.save(this.user).subscribe(result => this.gotoUserList());
  }



  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
