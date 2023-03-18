import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginRequest } from '../_models/LoginRequest';
import { AuthService } from '../_services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss'],
  providers: [MessageService]
})
export class SignInComponent implements OnInit {

  form: FormGroup;

  loginRequest: LoginRequest = {
    username: "",
    password: ""
  }

  constructor(private messageService: MessageService, private formBuilder: FormBuilder, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        username: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(20)
          ]
        ],
        password: [
          '',
          [
            Validators.required,
            Validators.minLength(6),
            Validators.maxLength(32)
          ]
        ],
        role: [
          '',
          [
            Validators.required,
          ]
        ]
      }
    );
  }

  onSubmit() {
    if (this.form.get('username')?.valid && this.form.get('password')?.valid && this.form.get('role')?.valid) {

      this.loginRequest.username = this.form.get('username').value
      this.loginRequest.password = this.form.get('password').value

      this.authService.login(this.loginRequest, this.form.get('role').value).subscribe((response) => {

        this.messageService.add({ severity: 'success', summary: 'Succés', detail: 'Connecté(e) avec succés' });

        localStorage.setItem("id", response.id.toString())
        localStorage.setItem("user", JSON.stringify(response))
        localStorage.setItem("role", this.form.get('role').value)

        this.authService.logger.next(true)

        window.location.reload()

      }, (error) => {
        this.messageService.add({ severity: 'error', summary: 'Erreur', detail: 'Veuillez vérifier vos entrées' });
      })
    }
    else {
      this.messageService.add({ severity: 'error', summary: 'Erreur', detail: 'Veuillez vérifier vos entrées' });
    }
  }

}
