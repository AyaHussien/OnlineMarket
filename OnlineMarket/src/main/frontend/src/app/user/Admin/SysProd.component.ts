import { Component,OnInit } from '@angular/core';
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'sys-prod',
    templateUrl:'template/AddSysProd.html',
    providers : [BuyerService]    
  })

  export class SysProdComponent
  {
    constructor(private _userservice:BuyerService,private _route:Router){}

    AddSysProd(name:string,brand:string,Lp:number,Hp:number)
    {
        this._userservice.SysProd(name,brand,Lp,Hp).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam")
                    this._route.navigate(['/SysProd']);
                }
                
            else
                {
                    console.log("Ezay bt-add product mlo4 brand ya 7ywana")
                    this._route.navigate(['/SysProd']); 
                }
                 
        });
    }
  }