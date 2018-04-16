import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'add-store',
    templateUrl:'template/AddStore.html',
    providers : [BuyerService]    
    
  })

  export class AddStoreComponent
  {
      private name:string
      constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
      ngOnInit()
      {
          this.name=this.route.snapshot.params['name'];
      }
      Store(v1:string,v2:string,v3:string)
      {
        this._userservice.addStore(v1,this.name,v2,v3).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam")
                    this._route.navigate(['/sellerHome/'+this.name]);
                }
                
            else
                {
                    console.log("sorry l store da mwgod abl kda")
                    this._route.navigate(['/AddStore/'+this.name]); 
                }
                 
        });
      }
  }