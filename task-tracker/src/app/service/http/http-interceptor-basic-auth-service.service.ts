import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorBasicAuthServiceService implements HttpInterceptor{

  constructor() { }

  
  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let username = '1'
    let password = '123'
    let basicAuth = 'Basic ' + window.btoa(username + ':' + password);

    req = req.clone({
      setHeaders : {
        Authorization : basicAuth
      }
    })
    return next.handle(req)
  }


  
}
