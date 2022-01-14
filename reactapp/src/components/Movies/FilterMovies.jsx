import {React, useEffect, useState} from 'react';
import MovieService from '../services/MoviesService';
import NotFound  from '../PageNotFound';
import { Form } from 'react-bootstrap';

export default function FilterMovies(props) {
  const [genres, setGenres] = useState(null);

  useEffect(() => {
    MovieService.getGenres().then((response) => {
      console.log(response.data);
      setGenres(response.data);
    });
  }, []);


  const handleChangeGenre = (e) => {
    let obj = e.target.value; //genre object

    props.filterMovie(obj);
  };
  

  if(!genres) return <NotFound/>

  return (
    <div>
        <Form.Control as="select" onChange={handleChangeGenre} id="genre" required>
            <option value=""> -- Select a genre -- </option>
            {genres.map((option, index) => (
              <option key={index} value={option}>
                {option}
              </option>
            ))}
      </Form.Control>
    </div>
  )
}
