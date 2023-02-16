import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ReaderService} from '../../service/reader.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Reader} from '../../model/reader';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  rfReader: FormGroup | undefined;
  readerId: number | undefined;
  reader: Reader | undefined;

  constructor(private readerService: ReaderService,
              private formBuilder: FormBuilder,
              private activateRout: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.getEditReader();
  }

  // tslint:disable-next-line:typedef
  getEditReader(readerId: number) {
    // @ts-ignore
    this.readerService.update(readerId).subscribe(reader => {
      this.reader = reader;
      this.rfReader = this.formBuilder.group({
        id: [reader.id],
        name: [reader.name],
        yearOld: [reader.yearOld],
      });
    });
  }

}
