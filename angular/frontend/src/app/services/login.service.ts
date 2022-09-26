import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageServiceService } from './token-storage-service.service';

const API_URL = "http://localhost:8082/api/v1/digitalbooks/auth/";
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  roles: string[] = [];

  constructor(public client: HttpClient,  private tokenStorage: TokenStorageServiceService) { }

  login(username: string, password: string): Observable<any> {
    return this.client.post(API_URL + 'signin', {
      username,
      password
    }, httpOptions);
  }

  public isLoggedIn(){
    let tokenStr= this.tokenStorage.getToken();
    if(tokenStr==undefined || tokenStr == ''|| tokenStr==null){
      return false;
    }else{
      return true;
    }
  }
  public logout(){
   this.tokenStorage.signOut();
    return true;
  }

  public getToken(){
    return this.tokenStorage.getToken();
  }

  public setUser(user: any){
    this.tokenStorage.saveUser(user);
  }

  public getUser(){
      return this.tokenStorage.getUser();
  }

  public getUserRole(){
    let user= this.getUser()
    this.roles = this.tokenStorage.getUser().roles;
    for(let role of this.roles){
      if(null != role){
        return role;
      }
    }
    return null;
  }
}
