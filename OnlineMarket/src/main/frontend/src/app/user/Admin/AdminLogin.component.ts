import { Component,OnInit } from '@angular/core';
import { UserEntity } from '../userEntity';
import { BuyerService } from '../../services/buyer.service'
import { Router } from '@angular/router'; 

@Component({
    selector: 'admin-Login',
    templateUrl:'template/Form.html',
    providers : [BuyerService]    
  })

  export class AdminLoginComponent
  {
    private user:UserEntity;
    constructor(private _userservice:BuyerService,private _route:Router)
    {
      // this.user=this._userservice.getter();
    }
    processForm(value1:string,value2:string)
    {
       console.log("admin login");
       console.log(value1);
       console.log(value2);
       this._userservice.AdmLogin(value1,value2).subscribe((user)=>{
           console.log(user)
           if(user==true)
               {
                   console.log("mwgod")
                   this._route.navigate(['/adminHome']);
               }
               
           else
               {
                   console.log("enta m4 admin l2 ya kdaaab")
                   this._route.navigate(['/adminLogin']); 
               }
                
       });
              
    }
  }