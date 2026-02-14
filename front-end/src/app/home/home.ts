import { Component, signal, input } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  constructor() {}
  name = signal( 'some value');  
  message = input('we will change this.');
}
