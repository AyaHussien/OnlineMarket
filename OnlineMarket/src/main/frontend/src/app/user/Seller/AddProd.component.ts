import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'add-prod',
    templateUrl:'template/AddProd.html',
    providers : [BuyerService]    
    
  })

  export class AddProdComponent
  {
      private name:string
      private st:string
      constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
      ngOnInit()
      {
          this.name=this.route.snapshot.params['name'];
          this.st=this.route.snapshot.params['st'];
      }
      Prod(v1:string,v3:number,v4:string,v5:number)
      {
        this._userservice.addProd(v1,this.st,v3,v4,v5).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam "+this.st)
                    this._route.navigate(['/sellerHome/'+this.name]);
                }
                
            else
                {
                    console.log("howa 7aga mn l etnen .. ye ema mfe4 l brand da asln .. ya ema l product m4 mwgod fl sys")
                    this._route.navigate(['/AddProd/'+this.name+'/'+this.st]); 
                }
                 
        });
      }
  }