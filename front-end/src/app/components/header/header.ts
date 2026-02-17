import { Component, signal } from '@angular/core';
import { RouterLink} from '@angular/router'

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  protected readonly title = signal("Home");
  protected readonly name = signal("Flickr Photo Calendar");
  
}
