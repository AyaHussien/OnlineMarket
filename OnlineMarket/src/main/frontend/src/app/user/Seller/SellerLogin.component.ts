import { Component,OnInit } from '@angular/core';
import { UserEntity } from '../userEntity';
import { BuyerService } from '../../services/buyer.service'
import { Router } from '@angular/router'; 

@Component({
    selector: 'seller-login',
    templateUrl:'template/Form.html',
    providers : [BuyerService]
  })

  export class SellerLoginComponent
  {
    private user:UserEntity;
    constructor(private _userservice:BuyerService,private _route:Router)
    {
      // this.user=this._userservice.getter();
    }
    processForm(value1:string,value2:string)
    {
       console.log("seller login");
       console.log(value1);
       console.log(value2);
       this._userservice.SellLogin(value1,value2).subscribe((user)=>{
           console.log(user)
           if(user==true)
               {
                   console.log("mwgod")
                   this._route.navigate(['/sellerHome/'+value1]);
               }
               
           else
               {
                   console.log("ro7 register l awl ya seller ya 7keeer")
                   this._route.navigate(['/sellerLogin']); 
               }
                
       });
              
    }
  }