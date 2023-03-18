import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConfirmationService, MessageService } from 'primeng/api';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  providers: [MessageService]
})
export class HeaderComponent implements OnInit {

  constructor(private confirmationService: ConfirmationService, private authService: AuthService, private router: Router, private messageService: MessageService) { }

  loggedIn: boolean = false

  roleClient: boolean = localStorage.getItem("role") == "client"
  roleAdmin: boolean = localStorage.getItem("role") == "admin"
  roleGerant: boolean = localStorage.getItem("role") == "gerant"

  ngOnInit(): void {
    this.loggedIn = localStorage.getItem("user") ? true : false

    this.authService.isUserLoggedIn().subscribe((loggedIn) => {
      this.loggedIn = loggedIn
    }, (error) => {
      console.log(error)
    })
  }

  deconnexion(event: Event) {
    this.confirmationService.confirm({
      target: event.target,
      message: 'Are you sure that you want to proceed?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        if (this.authService.deconnexion()) {
          this.loggedIn = false
          window.location.reload()
        }
      }
    });
  }

}
