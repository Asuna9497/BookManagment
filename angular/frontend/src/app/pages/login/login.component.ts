import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
import { TokenStorageServiceService } from 'src/app/services/token-storage-service.service';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginData = {
    username: '',
    password: ''
  }

  constructor(public userService: UserService, public loginService: LoginService,
    private snack: MatSnackBar, private tokenStorage: TokenStorageServiceService,
    private router: Router) { }

  ngOnInit(): void {

  }

  public formLogin() {
    const { username, password } = this.loginData;
    console.log("login button clicked!!");
    if (this.loginData.username.trim() == '' || this.loginData.username == null) {
      this.snack.open('UserName is required !!', '', {
        duration: 3000
      });
      return;
    }

    if (this.loginData.password.trim() == '' || this.loginData.password == null) {
      this.snack.open('password is required !!', '', {
        duration: 3000
      });
      return;
    }
    this.loginService.login(username, password).subscribe(
      (data) => {
        console.log(data)
        this.tokenStorage.saveToken(data.accessToken);
        this.loginService.setUser(data);
        if (this.loginService.getUserRole() == 'ROLE_READER') {
          this.router.navigate(['reader'])
        } else if (this.loginService.getUserRole() == 'ROLE_AUTHOR') {
          this.router.navigate(['author'])
        } else {

          this.loginService.logout();
        }

      },
      (error) => {
        console.log(error)
        this.snack.open('Invalid details !! Try again', '', {
          duration: 3000
        });
        this.loginService.logout();
      })
  }

}
