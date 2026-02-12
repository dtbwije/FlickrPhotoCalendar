import { Component, signal , OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  standalone: true,
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
  imports: [],
})

export class App  {
  name = 'Tharanga';
  protected readonly title = signal('Flickr-App');
  constructor(private route: ActivatedRoute) {}
}
