<?php

    $json = '
        {
            "MESSAGE_HEADER": {
                "SENDING_APPLICATION": "IQCARE",
                "SENDING_FACILITY": 10829,
                "RECEIVING_APPLICATION": "IL",
                "RECEIVING_FACILITY": 10829,
                "MESSAGE_DATETIME": "20170713110000",
                "SECURITY": "",
                "MESSAGE_TYPE": "ADT^A04",
                "PROCESSING_ID": "P"
            },
            "PATIENT_IDENTIFICATION": {
                "EXTERNAL_PATIENT_ID": {
                    "ID": "110ec58a-a0f2-4ac4-8393-c866d813b8d1",
                    "IDENTIFIER_TYPE": "GODS_NUMBER",
                    "ASSIGNING_AUTHORITY": "MPI"
                }
            }   
        }
    ';

    $object = json_decode($json);

    echo $object->MESSAGE_HEADER->SENDING_APPLICATION;

?>