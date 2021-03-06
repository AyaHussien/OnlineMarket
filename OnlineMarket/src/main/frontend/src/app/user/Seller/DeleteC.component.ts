import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'
import { BuyerService } from '../../services/buyer.service';
import { Router } from '@angular/router'; 

@Component({
    selector: 'deletec-prod',
    templateUrl:'template/DeleteProd.html',
    providers : [BuyerService]    
    
  })

  export class DeleteCComponent
  {
    private Pname:string
    private Cname:string    
    private st:string
    constructor(private route:ActivatedRoute,private _userservice:BuyerService,private _route:Router){}
    ngOnInit()
    {
        this.Pname=this.route.snapshot.params['pname'];
        this.st=this.route.snapshot.params['st'];
        this.Cname=this.route.snapshot.params['cname'];        
        
    }
    DO(v1:number)
    {
        this._userservice.DeleteC(this.Pname,this.st,v1,this.Cname).subscribe((user)=>{
            console.log(user)
            if(user==true)
                {
                    console.log("tmaaam "+this.st)
                    this._route.navigate(['/ShowProdsO/'+this.st]);
                }
            else
                {
                    console.log("l2")
                    this._route.navigate(['/DeleteC/'+this.Pname+'/'+this.st+'/'+this.Cname]); 
                }
                 
        });
    }
  }