import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { MatSnackBar} from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
import { TokenStorageServiceService } from 'src/app/services/token-storage-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginData={
    username:'',
    password:''
  }

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];


  constructor(public userService: UserService, private snack: MatSnackBar,private tokenStorage: TokenStorageServiceService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  public formLogin(){
    const { username, password } = this.loginData;
    console.log("login button clicked!!");
    if(this.loginData.username.trim() == '' || this.loginData.username == null){
      this.snack.open('UserName is required !!', '', {
        duration: 3000
      });
      return;
    }

    if(this.loginData.password.trim() == '' || this.loginData.password == null){
      this.snack.open('password is required !!', '', {
        duration: 3000
      });
      return;
    }
    this.userService.login(username, password).subscribe( 
      (data)=>{
        console.log(data)
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
       // this.reloadPage();
        Swal.fire('successfully done!!', this.loginData.username+ ' is logged in successfully', 'success');
    },
    (error)=>{
      console.log(error)
      this.snack.open('something went wrong!!', '', {
        duration: 3000
      });
      this.isLoginFailed = true;
    })
  }

  reloadPage(): void {
    window.location.reload();
  }

}
