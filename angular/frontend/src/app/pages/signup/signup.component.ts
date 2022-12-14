import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor(public userService: UserService, private snack: MatSnackBar) { }
  public user = {
    username: '',
    email: '',
    password: ''
  }

  ngOnInit(): void {
  }

  formSubmit() {

    if (this.user.username == '' || this.user.username == null) {
      this.snack.open('UserName is required !!', '', {
        duration: 3000
      });
      return;
    }
    if (this.user.password == '' || this.user.password == null) {
      this.snack.open('password is required !!', '', {
        duration: 3000
      });
      return;
    }
    if (this.user.email == '' || this.user.email == null) {
      this.snack.open('email is required !!', '', {
        duration: 3000
      });
      return;
    }
    this.userService.addUser(this.user).subscribe(
      (data) => {
        console.log(data)
        Swal.fire('successfully done!!', this.user.username + ' is registered successfully. Please login to proceed!', 'success');
      },
      (error) => {
        console.log(error)
        this.snack.open('something went wrong!!', '', {
          duration: 3000
        });
      }
    )
  }
}
