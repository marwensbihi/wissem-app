import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConfirmationService, MessageService } from 'primeng/api';
import { GerantService } from '../_services/gerant.service';

@Component({
  selector: 'app-gerant-list',
  templateUrl: './gerant-list.component.html',
  styleUrls: ['./gerant-list.component.scss'],
  providers: [MessageService]
})
export class GerantListComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private messageService: MessageService, private gerantService: GerantService, private confirmationService: ConfirmationService, private router: Router) { }

  form: FormGroup

  registerRequest: any = {
    email: "",
    id: null,
    nom: "",
    prenom: "",
    numTel: null,
    password: "",
    username: "",
    type: ""
  }

  displayModal: boolean = false;

  gerants: any[]

  showModal() {
    this.displayModal = true
  }

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
        numTel: [
          null,
          [
            Validators.required,
            Validators.pattern("[0-9]{8}")
          ]
        ],
        type: [
          "", Validators.required
        ]
      }
    );

    this.getAllGerants()
  }

  getAllGerants() {
    this.gerantService.getGerants().subscribe((response) => {
      this.gerants = response
    })
  }

  onSubmit() {
    if (this.form.get('username').valid &&
      this.form.get('password').valid &&
      this.form.get('email').valid &&
      this.form.get('nom').valid &&
      this.form.get('prenom').valid &&
      this.form.get('numTel').valid &&
      this.form.get('type').valid) {

      this.registerRequest.username = this.form.get('username').value
      this.registerRequest.password = this.form.get('password').value
      this.registerRequest.email = this.form.get('email').value
      this.registerRequest.nom = this.form.get('nom').value
      this.registerRequest.prenom = this.form.get('prenom').value
      this.registerRequest.numTel = this.form.get('numTel').value
      this.registerRequest.type = this.form.get('type').value

      this.gerantService.registerGerant(this.registerRequest).subscribe((response) => {

        window.location.reload()

      }, (error) => {
        this.messageService.add({ severity: 'error', summary: 'Erreur', detail: "Choisir un autre Login / E-mail" });
      })
    }
    else {
      this.messageService.add({ severity: 'error', summary: 'Erreur', detail: 'Veuillez vérifier vos entrées' });
    }
  }

  supprimerGerant(event: Event, id: number) {
    this.confirmationService.confirm({
      target: event.target,
      message: 'Are you sure that you want to proceed?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.gerantService.deleteGerant(id).subscribe((response) => {
          if (response) {
            this.messageService.add({ severity: 'success', summary: 'Réussit', detail: "Supprimé avec succés" });
            this.getAllGerants()
          }
        })
      }
    });
  }

  goToGerant(id: number) {
    this.router.navigateByUrl(`/gerants/${id}`)
  }


}

