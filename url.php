<?php
set_time_limit(0);
  $fh = fopen('C:\xampp\htdocs\empcode.txt','r');
  // $line = fgets($fh);
  // echo $line;

    while($line = fgets($fh)) {
   //$line = rtrim($line,"\n");
   $url="https://afternoon-oasis-93157.herokuapp.com/Employee/Search/5eb63bbbe01eeed093cb22bb8f5acdc3/" . $line;
   $url = substr($url,0,strlen($url)-2);
  $someArray =    json_decode(get_data($url), true); // Replace ... with your PHP Array
 foreach ($someArray as $key => $value) {
  echo $value["empage"] . ", " . $value["empname"] . "<br>";
   }
  }


//   // Loop through Object
//  /// $someObject =   json_decode(get_data($url)); // Replace ... with your PHP Object
//   //foreach($someObject as $key => $value) {
//     //echo $value->empname . ", " . $value->empage . "<br>";
//   //}
// //echo($url);
// }
function get_data($url)
{
$ch = curl_init();
//$timeout = 500;
curl_setopt($ch,CURLOPT_URL,$url);
curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
//curl_setopt($ch,CURLOPT_CONNECTTIMEOUT,$timeout);
$data = curl_exec($ch);
curl_close($ch);
return $data;
}
fclose($fh);
 //dumps the content, you can manipulate as you wish to
 
/* gets the data from a URL */
 



?>