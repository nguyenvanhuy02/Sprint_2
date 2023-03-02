import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginForm} from '../../model/security/login-form';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(loginForm: LoginForm): Observable<any> {
    return this.httpClient.post<any>(environment.login_url, loginForm);
  }
}
