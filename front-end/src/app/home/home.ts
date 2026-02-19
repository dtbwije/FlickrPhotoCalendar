import { Component, signal, input, inject } from '@angular/core';
import { HttpClient, HttpResponse } from  '@angular/common/http'

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  name = signal( 'some value');  
  message = input('we will change this.');
  
  http = inject(HttpClient);
  
  constructor() {
    
    this.getRequestToken()
    
  }

  getRequestToken() {
    console.log("Get Request Token button clicked");
    const url = 'http://localhost:8080/request_token';
      
    
    this.http.get<any>(url, { observe: 'response' }).subscribe((config: HttpResponse<any>) => {
      console.log('Response status:', config.status);
      console.log('Body:', config.body);
    });;  // Here you would typically make an HTTP request to your backend to initiate the OAuth flow 
  }
}


