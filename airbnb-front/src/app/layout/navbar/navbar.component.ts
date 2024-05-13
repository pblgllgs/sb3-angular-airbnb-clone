import {Component, inject, OnInit} from '@angular/core';
import {ToolbarModule} from "primeng/toolbar";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {MenuModule} from "primeng/menu";
import {AvatarComponent} from "./avatar/avatar.component";
import {CategoryComponent} from "./category/category.component";
import {MenuItem} from "primeng/api";
import {ToastService} from "../toast.service";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    ToolbarModule,
    FaIconComponent,
    MenuModule,
    AvatarComponent,
    CategoryComponent
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent implements OnInit{

  location = "Anywhere";
  guests = "Add guests";
  dates = "Any week";

  toastService = inject(ToastService);

  // login = () => this.authService.login();

  // logout = () => this.authService.logout();

  currentMenuItems: MenuItem[] | undefined = [];

  ngOnInit(): void {
    this.fetchMenu();
    this.toastService.send({severity: "info", summary:"Welcome to Your Angular.js App"});
  }


  private fetchMenu() {
    return [
      {
        label: "Sign up",
        styleClass: "font-bold"
      },
      {
        label: "Log in",
      }
    ]
  }
}
