import { Component,OnInit } from '@angular/core';
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'add-brand',
    templateUrl:'template/Brand.html',
    providers : [BuyerService]    
  })

  export class BrandComponent
  {
    constructor(private _userservice:BuyerService,private _route:Router){}

    AddBrand(name:string,des:string)
    {
        this._userservice.Brand(name,des).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam")
                    this._route.navigate(['/adminHome']);
                }
                
            else
                {
                    console.log("l brand mwgod asln ya bhayeem ya bhayeeem")
                    this._route.navigate(['/Brand']); 
                }
                 
        });
    }
  }