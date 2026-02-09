import { Component, signal } from '@angular/core';
import {app-flickr-auth-redirect} from

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('front-end');
}
