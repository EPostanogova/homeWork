using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CarController : MonoBehaviour
{
    private Rigidbody rb;
    public float speed = 5f, finalSpeed=15f,rotatSpeed=350f;
    private bool isClick;
    [NonSerialized]public Vector3 FinalPosition;

    private float curPointX, curPointY;
    
    public enum Axis {
        Vertical, Horizontal
    }
    public Axis carAxis;
    private enum Direction
    {
        Right, Left,Top,Bottom,None
    }
    private Direction directionX=Direction.None;
    private Direction directionY=Direction.None;
    private void Awake()
    {
        rb = GetComponent<Rigidbody>();
       

    }
    private void OnMouseDown()
    {
        curPointX= Input.mousePosition.x;
        curPointY = Input.mousePosition.y;
        //isClick = true;
    }
    private void OnMouseUp()
    {
        if (Input.mousePosition.x-curPointX>0)
            directionX=Direction.Right;
        else
            directionX = Direction.Left;
        if (Input.mousePosition.y - curPointY > 0)
            directionY = Direction.Top;
        else
            directionY = Direction.Bottom;
        isClick = true;
    }
    private void Update()
    {
        if (FinalPosition.x != 0) {
            transform.position = Vector3.MoveTowards(transform.position, FinalPosition, finalSpeed * Time.deltaTime);
            Vector3 lookAt = FinalPosition - transform.position;
            lookAt.y = 0;
            transform.rotation = Quaternion.RotateTowards(transform.rotation, Quaternion.LookRotation(lookAt), rotatSpeed * Time.deltaTime);
        }
        if(transform.position == FinalPosition) 
            Destroy(gameObject);
           
    }
    private void FixedUpdate()
    {
        if (isClick && FinalPosition.x==0)
        {
            Vector3 WAY=carAxis ==Axis.Horizontal ? Vector3.forward : Vector3.left;
            speed=Math.Abs(speed);
            if (directionX == Direction.Left && carAxis==Axis.Horizontal)
                speed *= -1;
            else if (directionY == Direction.Bottom && carAxis == Axis.Vertical)
                speed *= -1;

            rb.MovePosition(transform.position + WAY * speed * Time.fixedDeltaTime);
        }
    }
}
