import { Component, signal, inject  } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Header } from './components/header/header';

@Component({
  standalone: true,
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
  imports: [ Header, RouterOutlet ],
})

export class App  {
private activatedRoute = inject(ActivatedRoute)
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
    })
  }
}
