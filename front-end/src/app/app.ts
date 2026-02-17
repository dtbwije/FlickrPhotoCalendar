import { Component, signal, inject  } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';
import { HttpClient } from  '@angular/common/http'

@Component({
  standalone: true,
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
  imports: [ Header, RouterOutlet ],
})

export class App  {
private activatedRoute = inject(ActivatedRoute)
  http = inject(HttpClient);

  protected readonly title = signal('Flickr-App');
  protected readonly name = signal("some value");
  oauth_token :string ="";
  oauth_verifier:string="";


  constructor(private route: ActivatedRoute) {
    console.log(this.activatedRoute);
    

    this.route.queryParams.subscribe(params => {
        this.oauth_token=params['oauth_token']
        this.oauth_verifier=params['oauth_verifier']
        console.log(this.oauth_token + "000"+ this.oauth_verifier)
    });
    this.getVerificationToken(this.oauth_token, this.oauth_verifier);
  }

  getVerificationToken(token:string, verifier:string){
    console.log("getVerificationToken called with token: " + token + " and verifier: " + verifier)
    if(!token || !verifier){
      console.error("Token or verifier is missing. Token: " + token + ", Verifier: " + verifier);
      return;
    }
    const url = 'http://localhost:8080/access_Token?oauth_token=' + token + '&oauth_verifier=' + verifier;
    return this.http.get(url);
  }
}
