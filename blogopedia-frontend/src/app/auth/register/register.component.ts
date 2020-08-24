import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public register_username: String;
  public register_password : String;
  public register_password1 : String;
  public register_email: String;

  registerApplicantUrl = `/server/api/auth/signup`;


  constructor( private http: HttpClient) { }

  ngOnInit(): void {
  }

  registerApplicant()
  {
    this.http.post(this.registerApplicantUrl,{
      register_email:this.register_email,
      register_username: this.register_username,
      register_password: this.register_password,
      register_password1: this.register_password1

    }).toPromise().then( (data:any)=> {
      console.log(JSON.stringify(data));
      
    } )


  }

  get verifyPassword()
  {
    if(this.register_password==this.register_password1)
    {
      return true;
    }
    else return false;
  }





}
