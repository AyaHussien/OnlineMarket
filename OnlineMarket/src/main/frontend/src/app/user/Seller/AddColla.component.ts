import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'add-colla',
    templateUrl:'template/AddColla.html',
    providers : [BuyerService]    
    
  })

  export class AddCollaComponent
  {
    private name:string
    private st:string
    constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
    ngOnInit()
    {
        this.name=this.route.snapshot.params['name'];
        this.st=this.route.snapshot.params['st'];
    }
    Colla(v1:string)
    {
        this._userservice.addColla(v1,this.st,this.name).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam "+this.st)
                    this._route.navigate(['/sellerHome/'+this.name]);
                }
                
            else
                {
                    console.log("mfeee4 Colla hnaaaa")
                    this._route.navigate(['/AddColla/'+this.name+'/'+this.st]); 
                }
                 
        });
    }
  }