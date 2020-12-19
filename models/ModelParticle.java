// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelParticle extends ModelBase {
	private final ModelRenderer bone;

	public ModelParticle() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 20.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -2.0F, -6.0F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -5.0F, -2.0F, -4.0F, 1, 1, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, -4.0F, -3.0F, 1, 2, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -5.0F, -5.0F, -4.0F, 1, 3, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -4.0F, -6.0F, 5, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -4.0F, 3.0F, 4, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -4.0F, 2.0F, 6, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -5.0F, 2.0F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 2.0F, -4.0F, -5.0F, 1, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -4.0F, -3.0F, 1, 3, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 4.0F, -4.0F, -2.0F, 1, 2, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 3.0F, -5.0F, -2.0F, 1, 1, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -5.0F, -5.0F, 6, 5, 7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -4.0F, -4.0F, 5, 5, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, 2.0F, -5.0F, -4.0F, 1, 5, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -6.0F, -4.0F, 6, 1, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -7.0F, -3.0F, 4, 1, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, -6.0F, 1.0F, 3, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}