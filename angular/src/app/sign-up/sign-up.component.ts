import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../_services/auth.service';
import { Router } from '@angular/router';
import { RegisterRequest } from '../_models/RegisterRequest';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss'],
  providers: [MessageService]

})
export class SignUpComponent implements OnInit {

  form: FormGroup

  registerRequest: RegisterRequest = {
    adresse: "",
    codePostal: null,
    email: "",
    id: null,
    nom: "",
    prenom: "",
    numTel: null,
    password: "",
    username: "",
    ville: ""
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
        email: [
          '',
          [
            Validators.required,
            Validators.email
          ]
        ],
        nom: [
          '',
          [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(24)
          ]
        ],
        prenom: [
          '',
          [
            Validators.required,
            Validators.minLength(3),
            Validators.maxLength(20)
          ]
        ],
        adresse: [
          '',
          [
            Validators.minLength(3),
            Validators.maxLength(24)
          ]
        ],
        numTel: [
          null,
          [
            Validators.required,
            Validators.pattern("[0-9]{8}")
          ]
        ],
        codePostal: [
          null
        ],
        ville: [
          '',
          [
            Validators.minLength(3),
            Validators.maxLength(24)
          ]
        ],
      }
    );
  }

  onSubmit() {
    if (this.form.get('username').valid &&
      this.form.get('password').valid &&
      this.form.get('email').valid &&
      this.form.get('nom').valid &&
      this.form.get('prenom').valid &&
      this.form.get('numTel').valid) {

      this.registerRequest.username = this.form.get('username').value
      this.registerRequest.password = this.form.get('password').value
      this.registerRequest.email = this.form.get('email').value
      this.registerRequest.nom = this.form.get('nom').value
      this.registerRequest.prenom = this.form.get('prenom').value
      this.registerRequest.numTel = this.form.get('numTel').value
      this.registerRequest.ville = this.form.get('ville').value
      this.registerRequest.codePostal = this.form.get('codePostal').value
      this.registerRequest.adresse = this.form.get('adresse').value

      this.authService.registerClient(this.registerRequest).subscribe((response) => {

        this.messageService.add({ severity: 'success', summary: 'Succés', detail: 'Connecté(e) avec succés' });

        localStorage.setItem("id", response.id.toString())
        localStorage.setItem("user", JSON.stringify(response))
        localStorage.setItem("role", "client")

        window.location.reload()

      }, (error) => {
        this.messageService.add({ severity: 'error', summary: 'Erreur', detail: "Choisir un autre Login / E-mail" });
      })
    }
    else {
      this.messageService.add({ severity: 'error', summary: 'Erreur', detail: 'Veuillez vérifier vos entrées' });
    }
  }

}
