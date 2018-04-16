import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'Edit-prod',
    templateUrl:'template/EditProd.html',
    providers : [BuyerService]    
    
  })

  export class EditOComponent
  {
    private name:string
    private st:string
    constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
    ngOnInit()
    {
        this.name=this.route.snapshot.params['name'];
        this.st=this.route.snapshot.params['st'];
    }
    EO(v1:number)
    {
        this._userservice.EditO(this.name,this.st,v1).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam "+this.st)
                    this._route.navigate(['/ShowProdsO/'+this.st]);
                }
                
            else
                {
                    console.log("l2")
                    this._route.navigate(['/EditO/'+this.name+'/'+this.st]); 
                }
                 
        });
    }
  }