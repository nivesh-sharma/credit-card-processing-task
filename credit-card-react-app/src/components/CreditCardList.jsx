import React from 'react';
import Table from './CreditCardTable';


const CardList = props => {
	return(
		<>
			<label className="larger"> Existing Cards </label>
			{props.cards.length === 0 ? (
				<div> No Cards available in the system.</div>
			) : (
			  	<Table cards={props.cards} />
			)}
		</>
	)
}
	
export default CardList;
			