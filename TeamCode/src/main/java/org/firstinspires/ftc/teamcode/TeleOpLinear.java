package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name="9328: TeleOp Linear", group="9328")
public class TeleOpLinear extends LinearOpMode {
    private HardwareMap9328 hwMap = new HardwareMap9328();
    private int clawOpenPosition = new HardwareMap9328().clawOpenPosition;
    private int clawClosedPosition = new HardwareMap9328().clawClosedPosition;
    private double leftStick1 = gamepad1.left_stick_y, rightStick1 = gamepad1.right_stick_y, rightStick2 = gamepad2.right_stick_y;
    private boolean clawState = false;
    @Override
    public void runOpMode() {
        hwMap.init(hardwareMap);
        waitForStart();
        hwMap.claw.setTargetPosition(45);
        while (opModeIsActive()) {
            hwMap.leftTread.setPower(leftStick1);
            hwMap.rightTread.setPower(rightStick1);
            if (rightStick2 > 0.2 || rightStick2 < -0.2) {
                hwMap.clawWinch.setPower(rightStick2);
            } else if (gamepad2.right_stick_button & !clawState) {
                hwMap.claw.setTargetPosition(clawOpenPosition);
                clawState = true;
            } else if (gamepad2.right_stick_button & clawState) {
                hwMap.claw.setTargetPosition(clawClosedPosition);
                clawState = false;
            } else {
                hwMap.clawWinch.setPower(0);
            }
        }
    }
}