using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RoadFinishTrigger : MonoBehaviour
{
    public GameObject FinalPosition;
    
    void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Car"))
            other.GetComponent<CarController>().FinalPosition =FinalPosition.transform.position ;
       
    }
    
}
