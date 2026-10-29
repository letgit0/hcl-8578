import React, { useEffect, useState } from 'react'

function UseFetchApi() {

    const[serverData, setServerData] = useState([]);

    useEffect(()=>{

        async function   getData() {
            try{
                 
                const serverData = await fetch("http://localhost:8080/getemp")
                const jsonData = await serverData.json()
                console.log(jsonData)
                setServerData(jsonData);
            }
            catch(e){
                console.log(e);
            }
            
        }
        getData();

    })


  return (
    <div>
      UsefetchApi

      <h2>
        {
            JSON.stringify(serverData)
        }
      </h2>
    </div>
  )
}

export default UseFetchApi
