import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 
import { ActionEntity } from'../ActionEntity'

@Component({
    selector: 'history',
    templateUrl:'template/History.html',
    providers : [BuyerService]    
    
  })

  export class HistoryComponent
  {
      private Actions:ActionEntity[];    
      private owner:string
      constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
      ngOnInit()
      {
          this.owner=this.route.snapshot.params['name'];
          this._userservice.histo(this.owner).subscribe((Actions)=>{this.Actions=Actions});
          
      }
      Add1(v1:string,v2:number,v3:string,v4:string,v5:number,v6:number)
      {
        this._userservice.undo(v1,v2,v3,v4,v5,v6).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("mwgod")
                    this._route.navigate(['/sellerHome/'+this.owner]);
                }
                
            else
                {
                    console.log("l2 sorry")
                    this._route.navigate(['/history/'+this.owner]); 
                }
                 
        });
      }

   }