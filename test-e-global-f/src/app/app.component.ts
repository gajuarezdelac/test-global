
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Subscription } from 'rxjs';
import { TestService } from './services/test.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {


  public sub: Subscription = new Subscription;
  public form!: FormGroup;
  public submitted: boolean = false;
  public btnloader: boolean = false;  
  public showLoading : boolean  = false;
  public subcriptions : Subscription[] = [];

  public list : any;
  


  constructor(private fb: FormBuilder,private service : TestService) {}

  ngOnInit() {
    this.form = this.fb.group({ 
      num1: ['', [Validators.required]],
      num2: ['', [Validators.required]],
      operation: ['', [Validators.required]],
    });

    this.getResults();
  }

  get f() { return this.form.controls; }

  onSubmit(): void {
    
    this.submitted = true;

    // stop here if form is invalid
    if (this.form.invalid) { return; }
  
    this.btnloader = true;
    let form = this.form.value;


    this.subcriptions.push(
      this.service.newOperation(form).subscribe(
        (response: any) => {
          this.getResults();

          alert("Operación realiza correctamente")
        },
        (errorResponse: HttpErrorResponse) => {
          this.showLoading = false;
          this.btnloader = false;
        }
      )
    );
  }


  getResults(): void {
    
    this.subcriptions.push(
      this.service.getResults().subscribe(
        (response: any) => {
          
          this.list = response;
          
        },
        (errorResponse: HttpErrorResponse) => {
          this.showLoading = false;
          this.btnloader = false;
        }
      )
    );
  }
  
}
