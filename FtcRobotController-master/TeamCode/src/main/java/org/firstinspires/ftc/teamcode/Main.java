
//create package teamcode.
package org.firstinspires.ftc.teamcode;


//imports from qualcomm package.
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


// sets Op mode - TeleOp and not autonomous.
@TeleOp (name = "TeleOp", group = "Tutorial")

// what extends does is that Main class is able to inherit info from the parent class LinearOpMode.
// all code for Main class goes between the two brackets
public class Main.java extends LinearOpMode{

	// create attributes for diffrent parts of the robot


	// left motor 
	private DcMotor motorleft;
	//right motor
	private DcMotor motorright;
	// arm
	private Servo armServo;

	private static final double ARM_RETRACTED_POSITION = 0.2;
	private static final double ARM_EXTENDED_POSITION = 0.8;

  @Override
  public void runOpMode() throws InterupptedExeption{
    // assign to the harware map
		motorleft = hardwareMap.dcMotor.get("motorleft");
		motorright = hardwareMap.dcMotor.get("motorright");

		motorleft.setDrection(DcMotor.Direction.REVERSE);

		armServo = hardwareMap.servo.get("armServo");

		armServo.setPosition(ARM_RETRACTED_POSITION);
    
    // wait for start
		waitForStart();

    
		
		while (opModeIsActive()){

			//stick y refers to the y axis of the stick
			//setting the value to the movement of the gamepad stick
			motorleft.setPower(-gamepad1.left_stick_y);
			motorright.setPower(-gamepad1.right_stick_y);

			if(gamepad2.a){
				// extend the arm
				armServo.setPosition(ARM_EXTENDED_POSITION);
			}
			if(gamepad2.b){
				//retract the arm
				armServo.setPosition(ARM_RETRACTED_POSITION);
			}


			// lets hardware catch up
      idle();
    }
  }
}