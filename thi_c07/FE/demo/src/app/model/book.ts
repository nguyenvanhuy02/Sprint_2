import {Library} from './library';

export interface Book {
  id?: number;
  name?: string;
  price?: number;
  library?: Library;
}
