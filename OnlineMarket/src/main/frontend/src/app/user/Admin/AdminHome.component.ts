import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router'; 


@Component({
    selector: 'admin-home',
    templateUrl:'template/AdminHome.html'   
  })

  export class AdminHomeComponent
  {
    constructor(private _route:Router)
    {}
    Add1()
    {
        this._route.navigate(['/SysProd']);
    }
    Add2()
    {
        this._route.navigate(['/Brand']);
    }
    Add3()
    {
        this._route.navigate(['/Stat']);
    }
  }