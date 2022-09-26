import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../pages/login/login.component';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  isLoggedIn = false;
  user = null;

  constructor(public login : LoginService) { }

  ngOnInit(): void {
    this.isLoggedIn =this.login.isLoggedIn();
    this.user = this.login.getUser();
  }

  public logout(){
    this.login.logout();
    this.isLoggedIn = false;
    this.user = null;
    window.location.reload();
  }

}
