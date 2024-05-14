import {Component, effect, inject, OnInit} from '@angular/core';
import {ToolbarModule} from "primeng/toolbar";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {MenuModule} from "primeng/menu";
import {AvatarComponent} from "./avatar/avatar.component";
import {CategoryComponent} from "./category/category.component";
import {MenuItem, MenuItemCommandEvent} from "primeng/api";
import {ToastService} from "../toast.service";
import {AuthService} from "../../core/auth/auth.service";
import {User} from "../../core/model/user.model";

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
export class NavbarComponent implements OnInit {

  location = "Anywhere";
  guests = "Add guests";
  dates = "Any week";

  toastService = inject(ToastService);
  authService = inject(AuthService);

  login = () => this.authService.login();

  logout = () => this.authService.logout();

  currentMenuItems: MenuItem[] | undefined = [];
  private connectedUser: User = {email: this.authService.notConnected};

  constructor() {
    effect(() => {
      if (this.authService.fetchUser().status === "OK") {
        this.connectedUser = this.authService.fetchUser().value!;
        this.currentMenuItems = this.fetchMenu();
      }
    });
  }

  ngOnInit(): void {
    this.authService.fetch(false);
  }


  private fetchMenu():MenuItem[] {
    if (this.authService.isAuthenticated()) {
      return [
        {
          label: "My properties",
          routerLink: "landlord/properties",
          visible: this.hasToBeLandlord()
        },
        {
          label: "My booking",
          routerLink: "booking",
        },
        {
          label: "My reservation",
          routerLink: "landlord/reservation",
          visible: this.hasToBeLandlord()
        },
        {
          label: "Log out",
          command: this.logout
        },
      ]
    } else {
      return [
        {
          label: "Sign up",
          styleClass: "font-bold",
          command: this.login
        },
        {
          label: "Log in",
          command: this.login
        }
      ]
    }

  }

  hasToBeLandlord() {
    return this.authService.hasAnyAuthority("ROLE_LANDLORD")
  }
}
