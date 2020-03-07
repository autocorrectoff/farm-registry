import { Component, OnInit } from '@angular/core';
import { RepositoryService } from 'src/app/services/repository.service';

@Component({
  selector: 'farm-app-farm-view',
  templateUrl: './farm-view.component.html',
  styleUrls: ['./farm-view.component.css']
})
export class FarmViewComponent implements OnInit {
  farms: any[];
  user: any;

  constructor(private repository: RepositoryService) { }

  ngOnInit() {
    this.repository.getData('farms/search').subscribe(data => {
      console.log(data);
      this.farms = data;
    });
  }

}
