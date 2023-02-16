import {Component, OnInit} from '@angular/core';
import {PageReader} from '../../model/pageReader';
import {ReaderService} from '../../service/reader.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  listReader: PageReader | undefined;
  idDelete: number | undefined;

  constructor(private readerService: ReaderService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.findAll(0);
  }

  // tslint:disable-next-line:typedef
  findAll(pageNumber: number) {
    this.readerService.findAll(pageNumber).subscribe(
      data => {
        this.listReader = data;
      }
    );
  }

  // tslint:disable-next-line:typedef
  gotoPage(pageNumber: number) {
    this.findAll(pageNumber);
  }


  // tslint:disable-next-line:typedef
  delete() {
    this.readerService.deleteById(this.idDelete).subscribe(data => {
      this.readerService.findAll(0).subscribe(data1 => {
        this.listReader = data1;
      });
    });
  }

  // tslint:disable-next-line:typedef
  getDeleteId(idDelete: number) {
    this.idDelete = idDelete;
  }
}
