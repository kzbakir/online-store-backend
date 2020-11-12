import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { BasicAuthenticationService } from '../basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterService {

  constructor(
    private basicAuthenticationService: BasicAuthenticationService,
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    let basicAuthenticationService = this.basicAuthenticationService
  }
}
