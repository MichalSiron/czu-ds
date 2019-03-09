import React from 'react';
import classes from './Doctor.css';

const doctor = (props) => (

    <article className={classes.Movie}>
        <h1>{props.name+ ' ' +props.surname}</h1>
        <div>{props.description}<p><strong>Popularity: </strong>Here is going to be surgery popularity</p></div>
    </article>
);

export default doctor;