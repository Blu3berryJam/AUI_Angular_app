import { Component } from '@angular/core';
import {HeaderComponent} from "./component/header/header.component";

/**
 * Application main component.
 */
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
 title:string = "FleetManager"

}
