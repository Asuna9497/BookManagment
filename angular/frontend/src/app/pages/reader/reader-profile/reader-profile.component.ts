import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-reader-profile',
  templateUrl: './reader-profile.component.html',
  styleUrls: ['./reader-profile.component.scss']
})
export class ReaderProfileComponent implements OnInit {

  constructor(public login: LoginService) { }

  ngOnInit(): void {
  }

}
