import {Component, OnInit} from '@angular/core';
import {ReaderService} from '../../service/reader.service';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {Book} from '../../model/book';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  rfReader: FormGroup | undefined;
  book: Book[] | undefined;

  constructor(private readerService: ReaderService,
              private readerBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.create();
  }

  create(): void {
    this.rfReader = this.readerBuilder.group({
      name: [''],
      yearOld: [''],
      book: ['']
    });
    this.readerService.findAllBook().subscribe(data => {
      this.book = data;
    });
  }

  onSubmit() {
    if (this.rfReader?.valid) {
      this.readerService.create(this.rfReader.value).subscribe(
        data => {
          this.router.navigateByUrl('/reader');
        }
      );
    }
  }
}
